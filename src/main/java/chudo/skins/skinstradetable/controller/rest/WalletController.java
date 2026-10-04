package chudo.skins.skinstradetable.controller.rest;

import chudo.skins.skinstradetable.dto.WalletDto;
import chudo.skins.skinstradetable.entity.WalletEntity;
import chudo.skins.skinstradetable.repository.WalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    Logger logger = LoggerFactory.getLogger(WalletController.class);
    WalletRepository walletRepository;

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createWallet(@RequestBody WalletDto walletDto) {
        logger.info("Received request /wallet/create");
        WalletEntity wallet = new WalletEntity();
        wallet.setWalletName(walletDto.getWalletName());
        wallet.setWalletDescription(walletDto.getWalletDescription());
        wallet.setWalletTotalAmount(walletDto.getWalletTotalAmount());
        wallet.setTransactionsList(null);
        walletRepository.save(wallet);
        return new ResponseEntity<>("wallet: " + walletDto.getWalletName() + " create", HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<WalletDto>> getAllWallets() {
        logger.info("Received request /wallet/get/all");
        List<WalletEntity> walletsEntity = walletRepository.findAll();
        List<WalletDto> wallets = new ArrayList<>();
        for (WalletEntity walletEntity : walletsEntity) {
            wallets.add(new WalletDto(
                    walletEntity.getId(),
                    walletEntity.getWalletName(),
                    walletEntity.getWalletDescription(),
                    walletEntity.getWalletTotalAmount()));
        }

        return new ResponseEntity<>(wallets, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<WalletDto> getWalletById(@PathVariable("id") Long id) {
        logger.info("Received request /wallet/get/{id}");
        Optional<WalletEntity> walletEntity = walletRepository.findById(id);

        WalletDto walletDto = new WalletDto(
                walletEntity.get().getId(),
                walletEntity.get().getWalletName(),
                walletEntity.get().getWalletDescription(),
                walletEntity.get().getWalletTotalAmount());

        return new ResponseEntity<>(walletDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWallet(@PathVariable("id") Long id) {
        logger.info("Received request /wallet/delete/{id}");
        walletRepository.deleteById(id);
        return new ResponseEntity<>("wallet: " + id + " deleted", HttpStatus.OK);
    }
}
