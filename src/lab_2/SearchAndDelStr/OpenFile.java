package lab_2.SearchAndDelStr;

import Model.BookInfo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by user on 10.05.2017.
 */
public class OpenFile {
    private FileWorker fileWorker;

    public OpenFile(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("xml", fileWorker.EXTENSION));

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                fileWorker.model.getBookInfo().clear();
                DefaultHandler handler = new DefaultHandler() {
                    private String nameBook = "";
                    private String lastName = "";
                    private String firstName = "";
                    private String surName = "";
                    private String publishingHouse = "";
                    private String numberVolumes = "";
                    private String circulation = "";
                    private String totalVolumes = "";
                    // private List<String> socialWork = new ArrayList<String>();
                    // boolean isSocialWork = false;

                    @Override

                    public void startElement(String uri, String localName, String qName, Attributes attributes)

                            throws SAXException {

                        if (qName.equalsIgnoreCase(fileWorker.BOOK_INFO)) {
                            nameBook = attributes.getValue(fileWorker.NAME_BOOK);
                            lastName = attributes.getValue(fileWorker.LAST_NAME_AUTHOR);
                            firstName = attributes.getValue(fileWorker.FIRST_NAME_AUTHOR);
                            surName = attributes.getValue(fileWorker.SUR_NAME_AUTHOR);
                            publishingHouse = attributes.getValue(fileWorker.PUBLISHING_HOUSE);
                            numberVolumes = attributes.getValue(fileWorker.NUMBER_VOLUMES);
                            circulation = attributes.getValue(fileWorker.CIRCULATION);
                            totalVolumes = attributes.getValue(fileWorker.TOTAL_VOLUMES);
                        }

                    }

                    @Override
                    public void endElement(String uri, String localName, String qName) throws SAXException {

                        fileWorker.model.getBookInfo().add(new BookInfo(nameBook,
                                lastName,
                                firstName,
                                surName,
                                publishingHouse,
                                Integer.parseInt(numberVolumes),
                                Integer.parseInt(circulation),
                                Integer.parseInt(totalVolumes)));
                    }

                };

                saxParser.parse(new File(fileChooser.getSelectedFile().getPath()), handler);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }
}
