package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import java.util.List;

// list the objects in the bucket specified
// argument should be <bucket-name>
public class ListObjects {
    public static void main(String[] args)
    {
        if (args.length < 1) {
            System.exit(1);
        }
        String bucket_name = args[0];

        System.out.format("Objects in S3 bucket %s:\n", bucket_name);

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        ListObjectsV2Result result = s3.listObjectsV2(bucket_name);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        for (S3ObjectSummary os: objects) {
            System.out.println("* " + os.getKey());
        }
    }
}
