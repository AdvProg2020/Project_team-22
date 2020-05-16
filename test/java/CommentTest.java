import main.java.model.comment.Comment;
import org.junit.Assert;
import org.junit.Test;

public class CommentTest {
    Comment testComment = new Comment("I recommend buying this good", "Very efficient");

    @Test
    public void getOpinionTitle() {
        Assert.assertEquals("I recommend buying this good", testComment.getOpinionTitle());
    }

    @Test
    public void getOpinionContent() {
        Assert.assertEquals("Very efficient", testComment.getOpinionContent());
    }
}
