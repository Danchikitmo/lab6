package Data;

import com.google.gson.annotations.SerializedName;

import java.util.Vector;


public class Works {
    @SerializedName("added-works")
    public Vector<LabWork> labWorks = new Vector<>();

    public void addLabWorkToLabWork(LabWork labWork){
        labWorks.add(labWork);
    }

    public Vector<LabWork> getLabWorks() throws NullPointerException{
        return labWorks;
    }
}
