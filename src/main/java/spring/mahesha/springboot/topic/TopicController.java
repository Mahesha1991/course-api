package spring.mahesha.springboot.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String name) {
	
		return topicService.getTopic(name);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		//If the content type is JSON while sending springboot tries to create a object of the Topic type
		topicService.addTopic(topic);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		//If the content type is JSON while sending springboot tries to create a object of the Topic type
		topicService.updateTopic(id, topic);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		
	}
}
