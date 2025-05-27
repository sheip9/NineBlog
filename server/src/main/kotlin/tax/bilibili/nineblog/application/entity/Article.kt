package tax.bilibili.nineblog.application.entity

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import tax.bilibili.nineblog.application.constant.ObjectId
import java.time.ZonedDateTime

//@Table(value = "#{@dataSource.tablePrefix}article")
@Entity
data class Article (
    @jakarta.persistence.Id
    override val id: ObjectId,
    val authorId: ObjectId,
    var title: String,
    var content: String,
    var visibilityLevel: Int,
    override val createdAt: ZonedDateTime,
    override val updatedAt: ZonedDateTime,
) : BaseEntity
