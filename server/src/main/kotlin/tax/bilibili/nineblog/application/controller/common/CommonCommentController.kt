package tax.bilibili.nineblog.application.controller.common

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tax.bilibili.nineblog.application.annoucement.CommonApi
import tax.bilibili.nineblog.application.constant.EntityId
import tax.bilibili.nineblog.application.model.dataTransfer.CommentDTO
import tax.bilibili.nineblog.application.service.CommentService

@RestController
@CommonApi
@RequestMapping("/comments")
class CommonCommentController @Autowired constructor(val service: CommentService) {
    @GetMapping
    fun getByArticleId(@RequestParam(value = "articleId") @NotEmpty articleId: EntityId, @RequestParam @Positive page: Int = 1, @RequestParam @Positive limit: Int = 10) = service.findByArticleId(articleId, page, limit)

    @GetMapping("/count")
    fun countByArticleId(@RequestParam(value = "articleId") @NotEmpty articleId: EntityId) = service.countCommentByArticleId(articleId)

    @PostMapping
    fun submitComment(@RequestBody @Validated commentDto: CommentDTO, @RequestHeader("User-Agent") userAgent: String, @RequestHeader("X-Real-IP") ipAddress: String) = service.save(commentDto)
}