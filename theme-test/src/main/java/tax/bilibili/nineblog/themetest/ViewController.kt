package tax.bilibili.nineblog.themetest


import org.springframework.stereotype.Controller
import tax.bilibili.nineblog.view.controller.IViewController

@Controller
class ViewController : IViewController {

    override fun toHomePage() : String {
        return "index"
    }
}