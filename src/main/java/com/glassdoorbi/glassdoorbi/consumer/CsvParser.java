package com.glassdoorbi.glassdoorbi.consumer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

public class CsvParser {
  public void parse(File csvFile) {
      try (ICsvMapReader mapReader = new CsvMapReader(new FileReader(csvFile),  CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE)) {

        final String[] headers = mapReader.getHeader(true);
        final CellProcessor[] processors = getProcessors();
        Map<String, Object> customerMap;

      } catch (IOException e) {

      }
  }
}
