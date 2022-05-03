/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

/**
 *
 * @author Admin
 */
public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;

    public MyKnowledgeModel() {
    }
    
    
    public MyKnowledgeModel(String filename, String m_opts, String d_opts) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
        this.model_options = weka.core.Utils.splitOptions(m_opts);
        this.data_options = weka.core.Utils.splitOptions(d_opts);
    }

    MyKnowledgeModel(String cProgram_FilesWeka386datairisarff) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Instances removeData(Instances originalData) throws Exception{
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
    
    public Instances convertData(Instances originalData) throws Exception{
        NumericToNominal n2n = new NumericToNominal();
        n2n.setOptions(data_options);
        n2n.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2n);
    }
    
    public Instances convert2Binary(Instances originalData) throws Exception{
        NominalToBinary n2b = new NominalToBinary();
        n2b.setOptions(data_options);
        n2b.setBinaryAttributesNominal(true);
        n2b.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2b);
    }
    
    public void XuatData(String filename) throws IOException{
        ArffSaver outData = new ArffSaver();
        outData.setInstances(this.dataset);
        outData.setFile(new File(filename));
        outData.writeBatch();
        System.out.println("Saving Finished");
    }
    
    public void XuatData2(String filename) throws IOException{
        CSVSaver outdata = new CSVSaver();
        outdata.setFile(new File(filename));
        outdata.setInstances(this.dataset);
        outdata.writeBatch();
        System.out.println("Converted");
    }

    @Override
    public String toString() {
        return dataset.toSummaryString();
    }
    
    
    
    
    

    
    
    

  
    
    
}
