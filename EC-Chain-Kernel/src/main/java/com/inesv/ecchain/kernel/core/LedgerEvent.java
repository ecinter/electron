package com.inesv.ecchain.kernel.core;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


public enum LedgerEvent {

    BLOCK_GENERATED(1, false),
    REJECT_PHASED_TRANSACTION(2, true),
    TRANSACTION_FEE(50, true),
    ORDINARY_PAYMENT(3, true),
    ACCOUNT_INFO(4, true),
    ALIAS_ASSIGNMENT(5, true),
    ALIAS_BUY(6, true),
    ALIAS_DELETE(7, true),
    ALIAS_SELL(8, true),
    ARBITRARY_MESSAGE(9, true),
    HUB_ANNOUNCEMENT(10, true),
    PHASING_VOTE_CASTING(11, true),
    POLL_CREATION(12, true),
    VOTE_CASTING(13, true),
    ACCOUNT_PROPERTY(56, true),
    ACCOUNT_PROPERTY_DELETE(57, true),
    ASSET_ASK_ORDER_CANCELLATION(14, true),
    ASSET_ASK_ORDER_PLACEMENT(15, true),
    ASSET_BID_ORDER_CANCELLATION(16, true),
    ASSET_BID_ORDER_PLACEMENT(17, true),
    ASSET_DIVIDEND_PAYMENT(18, true),
    ASSET_ISSUANCE(19, true),
    ASSET_TRADE(20, true),
    ASSET_TRANSFER(21, true),
    ASSET_DELETE(49, true),
    DIGITAL_GOODS_DELISTED(22, true),
    DIGITAL_GOODS_DELISTING(23, true),
    DIGITAL_GOODS_DELIVERY(24, true),
    DIGITAL_GOODS_FEEDBACK(25, true),
    DIGITAL_GOODS_LISTING(26, true),
    DIGITAL_GOODS_PRICE_CHANGE(27, true),
    DIGITAL_GOODS_PURCHASE(28, true),
    DIGITAL_GOODS_PURCHASE_EXPIRED(29, true),
    DIGITAL_GOODS_QUANTITY_CHANGE(30, true),
    DIGITAL_GOODS_REFUND(31, true),
    ACCOUNT_CONTROL_EFFECTIVE_BALANCE_LEASING(32, true),
    ACCOUNT_CONTROL_PHASING_ONLY(55, true),
    CURRENCY_DELETION(33, true),
    CURRENCY_DISTRIBUTION(34, true),
    CURRENCY_EXCHANGE(35, true),
    CURRENCY_EXCHANGE_BUY(36, true),
    CURRENCY_EXCHANGE_SELL(37, true),
    CURRENCY_ISSUANCE(38, true),
    CURRENCY_MINTING(39, true),
    CURRENCY_OFFER_EXPIRED(40, true),
    CURRENCY_OFFER_REPLACED(41, true),
    CURRENCY_PUBLISH_EXCHANGE_OFFER(42, true),
    CURRENCY_RESERVE_CLAIM(43, true),
    CURRENCY_RESERVE_INCREASE(44, true),
    CURRENCY_TRANSFER(45, true),
    CURRENCY_UNDO_CROWDFUNDING(46, true),
    TAGGED_DATA_UPLOAD(47, true),
    TAGGED_DATA_EXTEND(48, true),
    SHUFFLING_REGISTRATION(51, true),
    SHUFFLING_PROCESSING(52, true),
    SHUFFLING_CANCELLATION(53, true),
    SHUFFLING_DISTRIBUTION(54, true);

    private static final Map<Integer, LedgerEvent> eventMap = new HashMap<>();

    @PostConstruct
    public static void initPostConstruct() {
        for (LedgerEvent event : values()) {
            if (eventMap.put(event.code, event) != null) {
                throw new RuntimeException("LedgerEvent code " + event.code + " reused");
            }
        }
    }

    private final int code;

    private final boolean isTransaction;

    LedgerEvent(int code, boolean isTransaction) {
        this.code = code;
        this.isTransaction = isTransaction;
    }


    public static LedgerEvent fromCode(int code) {
        LedgerEvent event = eventMap.get(code);
        if (event == null) {
            throw new IllegalArgumentException("LedgerEvent code " + code + " is unknown");
        }
        return event;
    }


    public boolean isTransaction() {
        return isTransaction;
    }

    public int getCode() {
        return code;
    }
}
