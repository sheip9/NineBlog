package tax.bilibili.nineblog.application.controller.common

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.service.CommentService

@RestController
@CommonApi
@RequestMapping("/comments")
class CommonCommentController @Autowired constructor(val service: CommentService) {
    @GetMapping
    fun getByArticleId(@RequestParam(value = "articleId") articleId: Number) = service.findByArticleId(articleId)

    @PostMapping
    fun submitNew(@RequestBody commentDto: CommentDTO) = service.save(commentDto)
}