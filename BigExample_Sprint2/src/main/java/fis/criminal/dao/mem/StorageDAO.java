package fis.criminal.dao.mem;

import fis.criminal.dao.IStorageDAO;
import fis.criminal.model.Storage;

import java.util.List;
import java.util.Optional;

public class StorageDAO implements IStorageDAO {
    @Override
    public void save(Storage storage) {
        MemoryDataSource.STORAGES.add(storage);
    }

    @Override
    public Optional<Storage> get(long id) {

        return MemoryDataSource.STORAGES.stream()
                .filter(storage -> storage.getId() ==id)
                .findFirst();
    }

    @Override
    public List<Storage> getAll() {

        return MemoryDataSource.STORAGES;
    }

    @Override
    public List<Storage> update(Storage newStorage) {

        Optional<Storage> storage = get(newStorage.getId());
        if(storage.isPresent()){
            Storage updateStorage= storage.get();
            updateStorage.replaceWith(newStorage);
        }
        return null;
    }

    @Override
    public Storage delete(Storage storage) {
        MemoryDataSource.STORAGES.remove(storage);
        return null;
    }
}
