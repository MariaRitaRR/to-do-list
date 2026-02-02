package tech.ada.java.todolistapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class ShareRequest {
    private List<Long> participantIds;
}
