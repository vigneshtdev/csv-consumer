package com.glassdoorbi.glassdoorbi.consumer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

public class CsvParser {

  public void parse(File csvFile) {
    ICsvListReader listReader = null;
    try {
      listReader = new CsvListReader(new FileReader(csvFile), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);
      final String[] headers = listReader.getHeader(true);
      final CellProcessor[] processors = getProcessors(listReader.length());

      final List<Object> customerList = listReader.executeProcessors(processors);
      System.out.println(String.format("lineNo=%s, rowNo=%s, columns=%s, customerList=%s",
          listReader.getLineNumber(), listReader.getRowNumber(), customerList.size(), customerList));

    } catch (IOException e) {

    }
  }

  private static CellProcessor[] getProcessors(int numberOfColumns) {

    final CellProcessor[] processors = new CellProcessor[numberOfColumns];
    for (int i = 0; i < numberOfColumns; i++) {
      processors[i] = new Optional();
    }
    return processors;
  }
}
