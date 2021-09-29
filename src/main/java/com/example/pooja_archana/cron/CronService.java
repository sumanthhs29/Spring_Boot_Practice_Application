package com.example.pooja_archana.cron;

import com.example.pooja_archana.model.StoryEntity;
import com.example.pooja_archana.repository.StoryRepository;
import com.example.pooja_archana.service.StoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class CronService {

    @Autowired
    private StoryRepository storyRepository;

    public boolean isTimeOver(Date checkDate){
        long diff = new Date().getTime() - checkDate.getTime();
        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        int diffInDays = (int) ((new Date().getTime() - checkDate.getTime()) / (1000 * 60 * 60 * 24));
        return diffInDays>=2;
    }

//    @Scheduled(cron = "0 * * * * *")
    @Scheduled(fixedRate = 600000)
    public void incrementViews() {
        //Enable scheduling in main
        System.out.println("Cron job :");
        StoryEntity s = storyRepository.findById(2L).get();
        s.setViews(s.getViews()+1);
        storyRepository.save(s);
    }
}
