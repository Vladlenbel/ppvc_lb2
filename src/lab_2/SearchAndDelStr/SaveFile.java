package lab_2.SearchAndDelStr;

import Window.BookInfo;
import Model.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by user on 10.05.2017.
 */
public class SaveFile {
    private  FileWorker fileWorker;

    public SaveFile(FileWorker fileWorker)
    {
        this.fileWorker = fileWorker;
    }

    public void saveFile() {

        try {

            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

                Document doc = docBuilder.newDocument();
                Element rootElement = doc.createElement(fileWorker.BOOK_INFOS);
                doc.appendChild(rootElement);

                for (BookInfo bookInfo : fileWorker.model.getBookInfo()) {
                    Element bookEl = doc.createElement(fileWorker.BOOK_INFO);
                    rootElement.appendChild(bookEl);

                    Attr attr = doc.createAttribute(fileWorker.NAME_BOOK);
                    attr.setValue(bookInfo.getLastName());
                    bookEl.setAttributeNode(attr);

                    attr  = doc.createAttribute(fileWorker.FIRST_NAME_AUTHOR);
                    attr.setValue(bookInfo.getFirstName());
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.LAST_NAME_AUTHOR);
                    attr.setValue(bookInfo.getLastName());
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.SUR_NAME_AUTHOR);
                    attr.setValue(bookInfo.getFatherName());
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.PUBLISHING_HOUSE);
                    attr.setValue(bookInfo.getPublishingHouse());
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.NUMBER_VOLUMES);
                    attr.setValue( Integer.toString(bookInfo.getNumberVolumes()));
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.CIRCULATION);
                    attr.setValue( Integer.toString(bookInfo.getCirculation()));
                    bookEl.setAttributeNode(attr);

                    attr = doc.createAttribute(fileWorker.TOTAL_VOLUMES);
                    attr.setValue( Integer.toString(bookInfo.getTotalVolumes()));
                    bookEl.setAttributeNode(attr);

                    bookEl.setAttributeNode(attr);

                   /* for (String socialWork : bookInfo.getSemNumber()) {
                        Element firstname = doc.createElement(fileWorker.SOCIAL_WORK);
                        firstname.appendChild(doc.createTextNode(socialWork));
                        bookEl.appendChild(firstname);
                    }*/

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(fc.getSelectedFile() + "." + fileWorker.EXTENSION));
                    transformer.transform(source, result);
                }
            }

        } catch (ParserConfigurationException pce) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        }catch (TransformerException tfe) {

            JOptionPane.showMessageDialog(null, "Не удалось сохранить файл", "Ошибка", JOptionPane.ERROR_MESSAGE | JOptionPane.OK_OPTION);

        }

    }

}
