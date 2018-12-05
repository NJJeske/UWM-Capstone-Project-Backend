package edu.uwm.capstone.controller;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class S3RestController {

    @Autowired
    private AmazonS3 s3;

    // Create bucket if user has not uploaded a file before, using the email as bucket name
    @RequestMapping(value = "/createBucket/{email}", method = RequestMethod.PUT)
    public void createBucket(@PathVariable String email){
        if (!this.s3.doesBucketExistV2(email)) {
            try {
                this.s3.createBucket(email);
            } catch (AmazonS3Exception e) {
                System.err.println(e.getErrorMessage());
            }
        }
    }

    // Upload file from file path
    @RequestMapping(value = "/uploadFile/{email}", method = RequestMethod.PUT)
    public void uploadFile(@RequestBody String filePath, @PathVariable String email) {
        String fileName = Paths.get(filePath).getFileName().toString();

        try {
            s3.putObject(email, fileName, new File(filePath));
        } catch (
                AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    // List the objects delimited by '|'
    @RequestMapping(value = "/listFiles/{email}", method = RequestMethod.GET)
    public String listFiles(@PathVariable String email){
        ListObjectsV2Result result = s3.listObjectsV2(email);
        List<S3ObjectSummary> objects = result.getObjectSummaries();
        String listOfFiles = "";
        for (S3ObjectSummary os: objects) {
            if (listOfFiles.length() == 0){
                listOfFiles += os.getKey();
            }
            else{
                listOfFiles +=  "|" + os.getKey();
            }
        }
        return listOfFiles;
    }

    // Delete file from provided path
    @RequestMapping(value = "/deleteFile/{email}", method = RequestMethod.DELETE)
    public void deleteFile(@RequestBody String filePath, @PathVariable String email){
        String fileName = Paths.get(filePath).getFileName().toString();
        try {
            s3.deleteObject(email, fileName);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    // Download file with specified name
    @RequestMapping(value = "/getFile/{email}", method = RequestMethod.GET)
    public void getFile(@RequestBody String fileName, @PathVariable String email){
        try {
            S3Object o = s3.getObject(email, fileName);
            S3ObjectInputStream s3is = o.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            byte[] readBuf = new byte[1024];
            int readLen = 0;
            while ((readLen = s3is.read(readBuf)) > 0) {
                fos.write(readBuf, 0, readLen);
            }
            s3is.close();
            fos.close();
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    // Helper function in order to get bucket using email
    public Bucket getBucket(String bucketName) {
        Bucket namedBucket = null;
        List<Bucket> buckets = s3.listBuckets();
        for (Bucket b : buckets) {
            if (b.getName().equals(bucketName)) {
                namedBucket = b;
            }
        }
        return namedBucket;
    }
}