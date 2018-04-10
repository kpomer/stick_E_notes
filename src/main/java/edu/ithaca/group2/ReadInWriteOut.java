package edu.ithaca.group2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import java.io.File;
import java.io.IOException;

public class ReadInWriteOut {

    /**
     *
     * @param workspace to write to the file
     * @param filename including the (full or relative) path to the file
     * @post workspace is written in json to file located at filename
     * @throws IOException if the file cannot be written (e.g. path is not found)
     */
    public static void writeToJson(Workspace workspace, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(filename), workspace);
    }

     /**
      *
      * @param filename to read from
      * @return Workspace object read from the file
      * @throws IOException if the file cannot be read (e.g. file is not found or format is incorrect)
      */
      public static Workspace buildWorkSpaceFromJson(String filename) throws IOException{
          ObjectMapper mapper = new ObjectMapper();

          return mapper.readValue(new File(filename), Workspace.class);
      }
}

