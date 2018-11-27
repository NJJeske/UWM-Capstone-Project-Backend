package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// supply the name of an S3 bucket and object to download from it.
// order of the arguments should be <bucketname> <filename>
public class GetObject {
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.exit(1);
        }

        String bucket_name = args[0];
        String key_name = args[1];

        System.out.format("Downloading %s from S3 bucket %s...\n", key_name, bucket_name);

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        try {
            S3Object o = s3.getObject(bucket_name, key_name);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(key_name));
            byte[] read_buf = new byte[1024];
            int read_len = 0;
            while ((read_len = s3is.read(read_buf)) > 0) {
                fos.write(read_buf, 0, read_len);
            }
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Successfully downloaded " + key_name + " from bucket " + bucket_name);
    }
}
