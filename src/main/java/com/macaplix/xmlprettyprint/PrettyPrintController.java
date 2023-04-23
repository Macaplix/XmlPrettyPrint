package com.macaplix.xmlprettyprint;

import org.xml.sax.InputSource;

//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Scanner;

import org.w3c.dom.*;
public class PrettyPrintController {
    private static final String ROOT_URL = "/Users/pe/classeur/banques/boursorama/2022/piratageCB/";
    //private static final String ROOT_URL = "/Users/pe/classeur/banques/boursorama/2023hackageCB/info/";
    public String run()
    {
/*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Complete Filepath or quit:");
        String response ="";
        while ( ( response = scanner.nextLine()) != "quit")
        {
            if ( ! response.isBlank()) break;
        }
        response = response.trim();
        File file = new File( response );
        if ( ! file.exists())
        {
            System.err.println("File " + response +" doesn't exist.");
            return "";
        }
        String xmlstring = "";
        try {
            xmlstring = readFile(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Project project = new Project(response);

        project.save("output.html", SaveFileFormat.HTML);

         try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            return e.getLocalizedMessage();

        }
         while (scanner.hasNext())
         {
             String chunk = scanner.next();
             xmlstring += chunk + "\n";

         }
*/
        xml2html("xmlstring");
        //System.out.println("xml scanner:\n" + xmlstring );
        String pretty = "ok";// prettyPrintByTransformer(xmlstring, 1, false);
        //System.out.println(prettyPrintByTransformer(xmlstring));
        return pretty;
    }
    private String xml2html(String xmlstring)
    {
        try {
            TransformerFactory tFactory=TransformerFactory.newInstance();

            Source xslDoc=new StreamSource( new File( ROOT_URL + "main_info.xsl"));
            Source xmlDoc=new StreamSource( new File(ROOT_URL + "main_info.xml"));

            String outputFileName=ROOT_URL + "main_info.html";

            OutputStream htmlFile=new FileOutputStream(outputFileName);
            Transformer trasform=tFactory.newTransformer(xslDoc);
            trasform.transform(xmlDoc, new StreamResult(htmlFile));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e)
        {
            e.printStackTrace();
        }
        catch (TransformerException e)
        {
            e.printStackTrace();
        }
        return "ok";
    }


    private String prettyPrintByTransformer(String xmlString, int indent, boolean ignoreDeclaration) {
        Writer out = new StringWriter();

        try {
            InputSource src = new InputSource(new StringReader(xmlString));
            Document document = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, ignoreDeclaration ? "yes" : "no");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (Exception e) {
            System.err.println("Error occurs when pretty-printing xml:\n" + xmlString + "\n" + e.getLocalizedMessage());
            //throw new RuntimeException("Error occurs when pretty-printing xml:\n" + xmlString, e);
        }
        return out.toString();
    }
    private String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader (file));
        String         line = null;
        StringBuilder  stringBuilder = new StringBuilder();
        String         ls = System.getProperty("line.separator");

        try {
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
}
