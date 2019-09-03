package assignment0.services;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.CreateTagsRequest;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
import software.amazon.awssdk.services.ec2.model.InstanceType;
import software.amazon.awssdk.services.ec2.model.RunInstancesRequest;
import software.amazon.awssdk.services.ec2.model.RunInstancesResponse;
import software.amazon.awssdk.services.ec2.model.Tag;
import assignment0.helper.Constants;

public class InstanceService {

	public void createInstance() {
		Ec2Client ec2 = Ec2Client.builder().region(Constants.MUMBAI_REGION).build(); // For Mumbai region

		RunInstancesRequest runRequest = RunInstancesRequest.builder().imageId(Constants.AMI_AI)
				.instanceType(InstanceType.T2_MICRO).maxCount(1).minCount(1).keyName(Constants.KEY_PAIR_NAME)
				.securityGroupIds(Constants.SECURITY_GROUP_ID_LIST).build();

		RunInstancesResponse response = ec2.runInstances(runRequest);

		String instance_id = response.instances().get(0).instanceId();

		Tag tag = Tag.builder().key("Name").value(Constants.INSTANCE_TAG).build();

		CreateTagsRequest tag_request = CreateTagsRequest.builder().resources(instance_id).tags(tag).build();

		try {
			ec2.createTags(tag_request);

			System.out.printf("Successfully started EC2 instance %s based on AMI %s", instance_id, Constants.AMI_AI);
		} catch (Ec2Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
