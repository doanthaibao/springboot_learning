package bao.doan.learning.connector.model;

import lombok.Data;

@Data
public class Note {
   private int userId;
   private int id;
   private String title;
   private boolean completed;
}
