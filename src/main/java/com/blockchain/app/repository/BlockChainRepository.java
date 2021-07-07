package com.blockchain.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blockchain.app.model.entity.BlockChainEntity;

public interface BlockChainRepository extends JpaRepository<BlockChainEntity, Long>{

}
