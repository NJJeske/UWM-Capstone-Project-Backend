package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.AmazonServiceException;

// supply the name of an S3 bucket and object name (key) to delete.
// order of the arguments should be <bucketname> <objectname>
public class DeleteObject {
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.exit(1);
        }

        String bucket_name = args[0];
        String object_key = args[1];

        System.out.format("Deleting object %s from S3 bucket: %s\n", object_key, bucket_name);

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        try {
            s3.deleteObject(bucket_name, object_key);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Successfully deleted the object named" + object_key + " from the bucket " + bucket_name);
    }
}
