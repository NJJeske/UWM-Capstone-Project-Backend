package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import java.util.Arrays;

// supply the name of an S3 bucket and at least one object name (key) to delete.
// order of the arguments should be <bucketname> <objectname1> [objectname2, ...]
public class DeleteObjects {
    public static void main(String[] args)
    {
        if (args.length < 2) {
            System.exit(1);
        }

        String bucket_name = args[0];
        String[] object_keys = Arrays.copyOfRange(args, 1, args.length);

        System.out.println("Deleting objects from S3 bucket: " + bucket_name);
        for (String k : object_keys) {
            System.out.println(" * " + k);
        }

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        try {
            DeleteObjectsRequest dor = new DeleteObjectsRequest(bucket_name)
                    .withKeys(object_keys);
            s3.deleteObjects(dor);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Successfully deleted the specified objects from the bucket " + bucket_name);
    }
}
