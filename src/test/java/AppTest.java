import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Create your own dictionary");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#inputtedWord").with("laconic");
    submit(".btn");
    click("a", withText("View all words"));
    assertThat(pageSource()).contains("laconic");
  }

  @Test
  public void wordsAreDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#inputtedWord").with("laconic");
    submit(".btn");
    click("a", withText("Add a new word"));
    fill("#inputtedWord").with("beatify");
    submit(".btn");
    assertThat(pageSource()).contains("laconic");
    assertThat(pageSource()).contains("beatify");
  }

  @Test
  public void wordDefinitionsIsDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#inputtedWord").with("laconic");
    submit(".btn");
    click("a", withText("laconic"));
    click("a", withText("Add a new definition"));
    fill("#description").with("using few words; expressing much in few words");
    submit(".btn");
    assertThat(pageSource()).contains("using few words; expressing much in few words");
  }

  @Test
  public void definitionsAreAddedAndDisplayed() {
    goTo("http://localhost:4567/words/new");
    fill("#inputtedWord").with("happy");
    submit(".btn");
    click("a", withText("happy"));
    click("a", withText("Add a new definition"));
    fill("#description").with("delighted");
    submit(".btn");
    click("a", withText("Add a new definition"));
    fill("#description").with("pleased");
    submit(".btn");
    assertThat(pageSource()).contains("delighted");
    assertThat(pageSource()).contains("pleased");
  }

}
