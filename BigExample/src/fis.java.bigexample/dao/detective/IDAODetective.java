package fis.java.bigexample.dao.detective;

import fis.java.bigexample.model.Detective;

public interface IDAODetective {
    public void add(Detective detective);
    public Detective remove(int code);
    public Detective update(Detective detective);
}
