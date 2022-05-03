/*
 //* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 //* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wekapro;

import weka.associations.Apriori;
import weka.core.Instances;

/**
 *
 * @author Admin
 */
public class MyAprioriModel extends MyKnowledgeModel {
    Apriori apriori;
    Instances newData;

    public MyAprioriModel() {
    }
    
    public MyAprioriModel(String filename, String m_opts, String d_opts) throws Exception {
        super(filename, m_opts,d_opts);
        this.apriori = new Apriori();
    }
    
    
    public void mineAssociationRules() throws Exception{
        //Loc du lieu
        //this.newData = removeData(this.dataset);
        this.newData = convertData(this.dataset);
        // Thiep lap thong so cho model Apriori
        apriori.setOptions(this.model_options);
        //Khai pha luat ket hop bang thuat toan Apriori
        apriori.buildAssociations(this.newData);
    }

    @Override
    public String toString() {
        return apriori.toString(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    
    
    
    
       
}
