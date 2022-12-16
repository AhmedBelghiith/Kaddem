package tn.spring.springboot.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entities.Contrat;
import tn.spring.springboot.entities.DetailEquipe;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.repository.DetailEquipeRepository;
import tn.spring.springboot.repository.EquipeRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DetailEqServiceImpl implements IDetailEqService {

    DetailEquipeRepository detailEquipeRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe getDetailEquipeById(Long idDetailEquipe) {
        return detailEquipeRepository.findDetailEquipeByIdDetailEquipe(idDetailEquipe);
    }


    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe) {
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public void deleteDetailEquipe(Long id) {
        detailEquipeRepository.deleteById(id);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }

    @Override
    public List<DetailEquipe> findBySalleLike(String salle) {
        return detailEquipeRepository.findBySalleLike(salle);
    }

    @Override
    public List<DetailEquipe> getAllDEquipes(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<DetailEquipe> pagedResult = detailEquipeRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<DetailEquipe>();
        }
    }

    @Override
    public List<DetailEquipe> searchDetailEquipes(String query) {
        List<DetailEquipe> detailEquipes = detailEquipeRepository.searchDetailEquipes(query);
        return detailEquipes;
    }

    @Override
    public DetailEquipe findDetailEquipeByEquipe(Long idEquipe) {
        return detailEquipeRepository.findDetailEquipeByEquipeIdEquipe(idEquipe);
    }

    @Override
    public List<DetailEquipe> getAllAsc() {
        List<DetailEquipe> detailEquipes =detailEquipeRepository.findAllAsc(Sort.by(Sort.Direction.ASC, "thematique"));
        return detailEquipes;
    }
    @Override
    public List<DetailEquipe> getAllDesc() {
        List<DetailEquipe> detailEquipes =detailEquipeRepository.findAllDesc(Sort.by(Sort.Direction.DESC, "thematique"));
        return detailEquipes;
    }

    @Transactional
    @Override
    public DetailEquipe addAndAssignDetailEquipeToEquipe(DetailEquipe detailEquipe, Long idEquipe) {
        Equipe equipe=this.equipeRepository.findById(idEquipe).orElse(null);
        equipe.setDetailEquipe(detailEquipe);
        return detailEquipeRepository.save(detailEquipe);
    }


}
