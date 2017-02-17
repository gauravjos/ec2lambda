package com.cybage;

import java.util.ArrayList;

import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class LambdaFunctionHandler implements RequestHandler<S3Event, Object> {

	@Override
	public Object handleRequest(S3Event input, Context context) {
		context.getLogger().log("Input: " + input);
		AmazonEC2Client amazonEC2Client = new AmazonEC2Client();
		ArrayList<String> instancelist = new ArrayList<>();
		instancelist.add("i-09eabacdabda25cb7");
		StopInstancesRequest stopInstancesRequest = new StopInstancesRequest(instancelist);
		amazonEC2Client.stopInstances(stopInstancesRequest);

		// TODO: implement your handler
		return "successfully stopped";
	}

}