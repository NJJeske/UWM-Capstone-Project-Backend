package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.AmazonServiceException;

public class CopyObject {
    public static void main(String[] args)
    {
        final String USAGE = "\n" +
                "To run this example, supply the name (key) of an S3 object, the bucket name\n" +
                "that it's contained within, and the bucket to copy it to.\n" +
                "\n" +
                "Ex: CopyObject <objectname> <frombucket> <tobucket>\n";

        if (args.length < 3) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String object_key = args[0];
        String from_bucket = args[1];
        String to_bucket = args[2];

        System.out.format("Copying object %s from bucket %s to %s\n",
                object_key, from_bucket, to_bucket);

        final BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        try {
            s3.copyObject(from_bucket, object_key, to_bucket, object_key);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }
}
