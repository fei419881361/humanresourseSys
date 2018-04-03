package service.serviceImpl;

import dao.RecruitmentMapper;
import entity.Recruitment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.RecruitmentService;

import java.util.List;

@Service
@Transactional
public class RecruitmentServiceImpl implements RecruitmentService {
    private final RecruitmentMapper recruitmentMapper;

    @Autowired
    public RecruitmentServiceImpl(RecruitmentMapper recruitmentMapper) {
        this.recruitmentMapper = recruitmentMapper;
    }

    @Override
    public List<Recruitment> findAllBySplit(Integer currentPage, Integer lineSize) {
        currentPage = (currentPage - 1) * lineSize;
        if (currentPage <= 0) {
            currentPage = 0;
        }
        return recruitmentMapper.findAllBySplit(currentPage, lineSize);
    }

    @Override
    public Integer getAllCount() {
        return recruitmentMapper.getAllCount();
    }

    @Override
    public boolean remove(Integer id) {
        return recruitmentMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean register(Recruitment recruitment) {
        return recruitmentMapper.insert(recruitment) > 0;
    }

    @Override
    public boolean update(Recruitment recruitment) {
        return recruitmentMapper.updateByPrimaryKey(recruitment) > 0;
    }
}
