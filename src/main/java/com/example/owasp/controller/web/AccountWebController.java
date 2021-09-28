package com.example.owasp.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.owasp.AccountRepository;
import com.example.owasp.models.Account;

@Controller
@RequestMapping("/web/account")
public class AccountWebController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping()
    public String accountPage() {
        return "account";
    }

	@GetMapping("/addAccount")
    public String addAccountView(Model model) {
        model.addAttribute("account", new Account());
        return "add-account";
    }
	
	@PostMapping("/addAccount")
    public RedirectView addBook(@ModelAttribute("account") Account account, 
    		RedirectAttributes redirectAttributes) {
        accountRepository.addAccount(account);
        final RedirectView redirectView = new RedirectView("/web/account/detail/" + account.getId(), true);
        redirectAttributes.addFlashAttribute("account", account);
        return redirectView;
    } 
	
	@GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") String id) {
		Account account = accountRepository.findByIdFixed(id);
		model.addAttribute("account", account);
        return "account-detail";
    }
	
	
	@GetMapping("/v1")
    public String findByLastNameWrong(Model model, @RequestParam("name") String name) {
		model.addAttribute("name", name);
        return "account-wrong";
    }
	@GetMapping("/v2")
	public String findByLastNameFix(Model model, @RequestParam("name") String name) {
		model.addAttribute("name", name);
		return "account";
	}
	
	
	
}
