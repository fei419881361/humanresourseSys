package service.serviceImpl;

import dao.TrainMapper;
import entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TrainService;

import java.util.List;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {
    private final TrainMapper trainMapper;

    @Autowired
    public TrainServiceImpl(TrainMapper trainMapper){
        this.trainMapper = trainMapper;
    }


    @Override
    public List<Train> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage - 1) * lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return trainMapper.findAllBySplit(currentPage, lineSize);
    }

    @Override
    public Integer getAllCount() {
        return trainMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return trainMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(Train train) {
        return trainMapper.insert(train) > 0;
    }

    @Override
    public boolean update(Train train) {
        return trainMapper.updateByPrimaryKey(train) > 0;
    }
}
