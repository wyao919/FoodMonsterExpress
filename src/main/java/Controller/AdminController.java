package Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entity.Menu;
import Service.MenuService;

@Controller
public class AdminController {

    private final MenuService menuService;

    @Autowired
    public AdminController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/")
    public String showAdminPage(Model model) {

//		System.out.println(auth.getCredentials());
        List<Menu> menuList = menuService.getMenu();

        model.addAttribute("menuItems", menuList);

        return "admin-page";
    }

    @GetMapping("/showAddItemPage")
    public String addMenu(@ModelAttribute("menu") Menu menu) {
        return "add-item-page";
    }

    @PostMapping("/save-item")
    public String saveMenuItem(@Valid @ModelAttribute("menu") Menu menuItem, BindingResult result) {

        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error);
            }
            return "add-item-page";
        }

        menuService.addMenuItem(menuItem);

        return "redirect:/";
    }

    @GetMapping("/showUpdatePage")
    public String showUpdatePage(@RequestParam("menuID") int menuId, Model model) {
        Menu menu = menuService.getMenu(menuId);
        model.addAttribute("menu", menu);

        return "add-item-page";
    }

    @GetMapping("/deleteMenuItem")
    public String deleteMenuItem(@RequestParam("menuID") int menuId, Model model) {

        menuService.deleteMenuItem(menuId);

        return "redirect:/";
    }

    @GetMapping("/searchItems")
    public String showSearchedItem(@RequestParam("itemName") String itemName, Model model) {

        List<Menu> menuList = menuService.searchItem(itemName);
        model.addAttribute("menuItems", menuList);

        return "admin-page";
    }

}
