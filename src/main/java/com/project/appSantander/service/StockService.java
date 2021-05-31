package com.project.appSantander.service;

import com.project.appSantander.exceptions.BusinessException;
import com.project.appSantander.exceptions.NotFoundException;
import com.project.appSantander.mapper.StockMapper;
import com.project.appSantander.model.Stock;
import com.project.appSantander.model.dto.StockDTO;
import com.project.appSantander.repository.StockRepository;
import com.project.appSantander.util.MessageUtils;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    //Método para salva dados no banco de dados
    @Transactional
    public StockDTO save(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if (optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    //Método para atualizar dados no banco de dados
    @Transactional
    public StockDTO update(StockDTO dto) {

        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getName(), dto.getDate(), dto.getId());
        if (optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    //Método para deletar dados no banco de dados
    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    //Método para pesquisar todos os dados no banco de dados
    @Transactional
    public List<StockDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    //Método para pesquisar dados por id no banco de dados
    @Transactional
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    //Método para pesquisar todos os dados pelo dia no banco de dados
    @Transactional
    public List<StockDTO> findByToday(){
        return repository.findByToday(LocalDate.now()).map(mapper::toDto).orElseThrow((NotFoundException::new));
    }

}
