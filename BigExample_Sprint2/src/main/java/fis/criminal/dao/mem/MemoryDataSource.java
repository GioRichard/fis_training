package fis.criminal.dao.mem;

import fis.criminal.model.CriminalCase;
import fis.criminal.model.Detective;
import fis.criminal.model.Evidence;

import java.util.ArrayList;
import java.util.List;

public class MemoryDataSource {
    public static final List<CriminalCase> CRIMINAL_CASES = new ArrayList();
    public static final List<Detective> DETECTIVES = new ArrayList();
    public  static  final  List<Evidence> EVIDENCES = new ArrayList<>();
}
