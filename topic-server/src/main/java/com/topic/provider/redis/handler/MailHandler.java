package com.topic.provider.redis.handler;

import com.topic.msg.dto.MessageBO;
import com.topic.provider.topic.manager.TopicManager;
import com.topic.provider.topic.observer.Topic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.topic.provider.utils.TopicConstants.SUB_MALL;
import static com.topic.provider.utils.TopicConstants.SUB_ORDER;

@Component
@Slf4j
public class MailHandler {




    @Autowired
    TopicManager topicManager;



    public void onEvent(MessageBO messageBO){


        //获取该topic
        Topic topic = topicManager.loadTopic(SUB_MALL);

        if (topic == null) {
            log.error("invalid topic, event={}", SUB_MALL);
            return;
        }
        topic.notify(messageBO);





    }


}
