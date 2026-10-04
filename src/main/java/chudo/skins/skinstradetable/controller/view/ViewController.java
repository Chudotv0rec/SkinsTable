package chudo.skins.skinstradetable.controller.view;

import chudo.skins.skinstradetable.entity.WalletEntity;
import chudo.skins.skinstradetable.repository.WalletRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/view")
public class ViewController {

    WalletRepository walletRepository;

    public ViewController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/wallet/create")
    public String createWalletPage() {
        return "createWalletPage";
    }

    @GetMapping("/wallet/{id}")
    public String walletDetailPage(@PathVariable Long id, Model model) {
        return walletRepository.findById(id)
                .map(wallet -> {
                    model.addAttribute("wallet", wallet); // ← сам WalletEntity
                    return "walletDetail";
                })
                .orElse("redirect:/view/wallets"); // если не найден — куда-нибудь редиректим
    }
}
