package com.stripe.functional;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

import com.stripe.BaseStripeTest;
import com.stripe.exception.StripeException;
import com.stripe.model.Token;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.TokenCreateParams;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TokenTest extends BaseStripeTest {
  public static final String TOKEN_ID = "tok_123";

  @Test
  public void testCreate() throws StripeException {
    final Map<String, Object> params = untypedCreateParams();

    final Token token = Token.create(params);

    assertNotNull(token);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/tokens",
        params
    );
  }

  private Map<String, Object> untypedCreateParams() {
    final Map<String, Object> card = new HashMap<>();
    card.put("number", "4242424242424242");
    card.put("exp_month", "11");
    card.put("exp_year", "2022");
    final Map<String, Object> params = new HashMap<>();
    params.put("card", card);
    return params;
  }

  @Test
  public void testCreateWithCardTypedParams() throws StripeException {
    final Map<String, Object> params = untypedCreateParams();

    TokenCreateParams.CreditCard card = TokenCreateParams.CreditCard.builder()
        .setNumber("4242424242424242")
        .setExpMonth("11")
        .setExpYear("2022")
        .build();

    TokenCreateParams createParams = TokenCreateParams.builder()
        .setCard(card)
        .build();

    assertTrue(createParams.getCard() instanceof TokenCreateParams.CreditCard);

    final Token token = Token.create(createParams, RequestOptions.getDefault());

    assertNotNull(token);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/tokens",
        params
    );
  }

  @Test
  public void testCreateWithApplePayTypedParams() throws StripeException {
    TokenCreateParams.ApplePay applePay = TokenCreateParams.ApplePay.builder()
        .setObject(TokenCreateParams.ApplePay.ObjectType.CARD)
        .setAddressCity("San Francisco")
        .setAddressCountry("USA")
        .setTokenCryptogramAmount(123L)
        .build();

    TokenCreateParams createParams = TokenCreateParams.builder()
        .setCard(applePay)
        .build();

    assertTrue(createParams.getCard() instanceof TokenCreateParams.ApplePay);

    final Token token = Token.create(createParams, RequestOptions.getDefault());

    assertNotNull(token);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/tokens",
        createParams.toMap()
    );
  }

  @Test
  public void testCreateWithSwipeDataParams() throws StripeException {
    TokenCreateParams.SwipeData swipeData = TokenCreateParams.SwipeData.builder()
        .setSwipeData("123")
        .setCvc("456")
        .build();

    TokenCreateParams createParams = TokenCreateParams.builder()
        .setCard(swipeData)
        .build();

    assertTrue(createParams.getCard() instanceof TokenCreateParams.SwipeData);

    final Token token = Token.create(createParams, RequestOptions.getDefault());

    assertNotNull(token);
    verifyRequest(
        ApiResource.RequestMethod.POST,
        "/v1/tokens",
        createParams.toMap()
    );
  }

  @Test
  public void testRetrieve() throws StripeException {
    final Token token = Token.retrieve(TOKEN_ID);

    assertNotNull(token);
    verifyRequest(
        ApiResource.RequestMethod.GET,
        String.format("/v1/tokens/%s", TOKEN_ID)
    );
  }
}
