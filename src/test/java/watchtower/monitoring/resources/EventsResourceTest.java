package watchtower.monitoring.resources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import io.dropwizard.testing.junit.ResourceTestRule;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import watchtower.common.event.Event;
import watchtower.common.event.EventUtils;
import watchtower.monitoring.producer.KafkaProducer;

@RunWith(MockitoJUnitRunner.class)
public class EventsResourceTest {
  public static KafkaProducer kafkaProducer = mock(KafkaProducer.class);

  @ClassRule
  public static final ResourceTestRule resources = ResourceTestRule.builder()
      .addResource(new EventsResource(kafkaProducer)).build();

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void shouldCreate() {
    Event event = new Event();

    Response response =
        resources.client().target("/v1.0/events").request()
            .post(Entity.entity(EventUtils.toJson(event), MediaType.APPLICATION_JSON));

    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldNotCreate() {
    exception.expect(ProcessingException.class);

    resources.client().target("/v1.0/events").request(MediaType.APPLICATION_JSON_TYPE)
        .post(Entity.entity("StringWhichCausesProcessingException", MediaType.APPLICATION_JSON));
  }
}