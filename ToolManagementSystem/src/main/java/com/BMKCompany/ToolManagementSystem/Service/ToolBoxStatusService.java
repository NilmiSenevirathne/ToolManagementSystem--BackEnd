package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.ToolBoxStatus;
import com.BMKCompany.ToolManagementSystem.repository.ToolBoxStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToolBoxStatusService {

        @Autowired
        private ToolBoxStatusRepository toolBoxStatusRepository;

        public ToolBoxStatus saveStatus(byte[] statusPdf) {
            ToolBoxStatus toolBoxStatus = new ToolBoxStatus();
            toolBoxStatus.setStatusPDF(statusPdf);
            toolBoxStatus.setCreated_at(LocalDateTime.now());
            return toolBoxStatusRepository.save(toolBoxStatus);
        }

        public List<ToolBoxStatus> getAllStatuses() {
            return toolBoxStatusRepository.findAll();
        }
    }


