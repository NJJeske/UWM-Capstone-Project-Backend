package edu.uwm.capstone.s3;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ListVersionsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;

public class DeleteBucket {
    public static void main(String[] args)
    {
        final String USAGE = "\n" +
                "To run this example, supply the name of an S3 bucket\n" +
                "\n" +
                "Ex: DeleteBucket <bucketname>\n";

        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(1);
        }

        String bucket_name = args[0];

        System.out.println("Deleting S3 bucket: " + bucket_name);
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAIAR6QLI6XLWJ4FWQ", "lHELWR4eRGlS0J9kPNS3S8AFYRouA+Jc1Mo2R+Qk");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();

        try {
            System.out.println(" - removing objects from bucket");
            ObjectListing object_listing = s3.listObjects(bucket_name);
            while (true) {
                for (Iterator<?> iterator =
                     object_listing.getObjectSummaries().iterator();
                     iterator.hasNext();) {
                    S3ObjectSummary summary = (S3ObjectSummary)iterator.next();
                    s3.deleteObject(bucket_name, summary.getKey());
                }

                // more object_listing to retrieve?
                if (object_listing.isTruncated()) {
                    object_listing = s3.listNextBatchOfObjects(object_listing);
                } else {
                    break;
                }
            };

            System.out.println(" - removing versions from bucket");
            VersionListing version_listing = s3.listVersions(
                    new ListVersionsRequest().withBucketName(bucket_name));
            while (true) {
                for (Iterator<?> iterator =
                     version_listing.getVersionSummaries().iterator();
                     iterator.hasNext();) {
                    S3VersionSummary vs = (S3VersionSummary)iterator.next();
                    s3.deleteVersion(
                            bucket_name, vs.getKey(), vs.getVersionId());
                }

                if (version_listing.isTruncated()) {
                    version_listing = s3.listNextBatchOfVersions(
                            version_listing);
                } else {
                    break;
                }
            }

            System.out.println(" OK, bucket ready to delete!");
            s3.deleteBucket(bucket_name);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Done!");
    }
}