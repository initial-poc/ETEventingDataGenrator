package com.infogain.et.tg.util;

public class EtConstants {

    public static final String OUTBOX = "OUTBOX";
    public static final String LOCATOR = "locator";
    public static final String VERSION = "version";
    public static final String CREATED = "created";
    public static final String PAYLOAD = "payload";
    public static final String STATUS = "status";
    public static final String SHARD="PNREventShardId";
    public static final String PNR_ID="pnr_id";
    public static final String COMMA = ",";

    public static final String DATA = "{\"@type\":\"ActionResponse\",\"header\":{\"id\":\"febf9c8c-4cfd-4a45-8d69-da7fae509e8f\",\"createTime\":1625143368533},\"requestHeader\":{\"id\":\"Blank: 571b2b68-ea0e-4611-b65b-cc9a86a82cc4\",\"createTime\":0},\"result\":[{\"@type\":\"ActionResult\",\"header\":{\"id\":\"952cf072-305a-43d6-a285-d0f196ffd2ae\",\"createTime\":1625143368533},\"source\":\"orsm-service\",\"status\":\"OK\",\"actionHeader\":{\"id\":\"Blank: 460ce692-c30b-4e1b-8b7f-4541c3985e75\",\"createTime\":0},\"resultData\":[{\"@type\":\"CartResultData\",\"cart\":{\"@type\":\"OpenResCart\",\"header\":{\"id\":\"fa1824bb-df1c-4eb7-97f7-3155f2f87e0d\",\"createTime\":1625143312590,\"version\":1625143312590},\"cartReference\":{\"id\":\"Shared/IDL:IceSess/SessMgr:1\\\\.0.IDL/Common/!ICESMS/STSA!ICESMSLB/STS.LB!1625143280668!5695!265!2!E2E-1\",\"type\":\"ORM_CART\",\"systemName\":\"ORS\"},\"content\":{\"ELEMENTS_DELTA\":{\"header\":{\"id\":\"75e9f284-998e-4c80-a54e-280ee8bffcca\",\"createTime\":1625143368533,\"version\":1625143368533},\"type\":\"ELEMENTS_DELTA\",\"elementsDelta\":{},\"@type\":\"ElementsDeltaContent@orsm\"},\"DELTAS_MAP\":{\"header\":{\"id\":\"3c045e45-27e2-404a-b0dc-e65140b51e2e\",\"createTime\":1625143368533,\"version\":1625143368533},\"type\":\"DELTAS_MAP\",\"deltasMap\":{\"PNR\":[],\"PNR_HISTORY\":[]},\"@type\":\"DeltasMapContent@orsm\"},\"PNR\":{\"header\":{\"id\":\"2a022f8b-4f0e-4004-8dc5-1f895aaced95\",\"createTime\":1625140118446,\"version\":1625140154431,\"@type\":\"VersionedHeader\"},\"type\":\"PNR\",\"associations\":{\"@type\":\"AssociationMatrix\",\"header\":{\"@type\":\"VersionedHeader\",\"id\":\"e671a1ef-b53a-40ab-a1ad-959a12cd14ef\",\"createTime\":1625140118446,\"version\":1625140118446},\"associations\":{}},\"pnr\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"af5b21a1-21b4-44be-b4bb-610ed1c9b643\",\"createTime\":1625140118446,\"version\":1625140154425,\"orsId\":8509634},\"pnrHeader\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"7d12e2d7-c61e-4958-9528-9b71fc77200e\",\"createTime\":1625140154411,\"version\":1625140154425,\"orsId\":8477443},\"locator\":\"MJADWN\",\"createDate\":\"2021-07-01T11:49:14.411431Z\",\"locatorCreateTime\":\"MJADWN2021-07-01\",\"etCount\":1,\"pnrPurgeDate\":\"2022-03-30\",\"lastEndTransactionDateAndTime\":\"2021-07-01T11:49:14.411467Z\",\"numberInParty\":1},\"names\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"12a841f7-8487-4d15-bc14-ced2fa94cb4d\",\"createTime\":1625140118446,\"version\":1625140131038,\"orsId\":8510057},\"items\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"e88c0b1e-63a6-482b-9672-2c26cf915778\",\"createTime\":1625140131023,\"version\":1625140154425,\"orsId\":10911432},\"items\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"0b93a972-25c9-4bc0-8048-30f53f8f7c20\",\"createTime\":1625140131023,\"version\":1625140131023,\"orsId\":10911265},\"firstName\":\"DHARMENDRA\",\"lastName\":\"KUMAR\",\"nameType\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"1988f6c8-4087-4f5f-bea9-2636c169235e\",\"createTime\":1625140131024,\"version\":1625140131024,\"orsId\":10912014},\"code\":\"ADT\"},\"nameId\":1,\"ordinal\":1,\"position\":1,\"primeNameIndicator\":true}]}]},\"phones\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"f687554b-9cc2-464e-bfbc-54a5f785d388\",\"createTime\":1625140118446,\"version\":1625140118468,\"orsId\":8511349},\"items\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"f92cb4e4-77e3-41ea-b536-b022674dff55\",\"createTime\":1625140118457,\"version\":1625140154425,\"orsId\":10341216},\"number\":\"DFW59595959\"}]},\"receivedFrom\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5e1ee5a5-5b19-4831-b9d2-31d99115e2df\",\"createTime\":1625140124099,\"version\":1625140154425,\"orsId\":13507532},\"receivedFrom\":\"-DAHRMENDRA\",\"type\":\"FREE_TEXT\"},\"products\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"f6246bfa-696f-4b3b-8da4-fd038275f922\",\"createTime\":1625140118446,\"version\":1625140135127,\"orsId\":8510285},\"products\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"39665b1c-631c-434a-902e-efc891d72650\",\"createTime\":1625140135115,\"version\":1625140154425,\"orsId\":10902707},\"cityCode\":\"BLR\",\"vendorCode\":\"AA\",\"actionCode\":\"GK\",\"previousActionCode\":\"GK\",\"numberInParty\":1,\"startDate\":\"2022-03-30\",\"segmentNumber\":1,\"productType\":\"OTHER\",\"otherProductDetails\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"cda206bc-e48e-4eee-af5b-1c03194a62d5\",\"createTime\":1625140135115,\"version\":1625140135115,\"orsId\":10902254}}}]},\"tickets\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"56b683fa-38dd-47c8-be55-38dd35e1feab\",\"createTime\":1625140118446,\"version\":1625140142881,\"orsId\":8511180},\"items\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"9c7f54ab-adfd-42dc-8058-e907d093108f\",\"createTime\":1625140142871,\"version\":1625140154425,\"orsId\":10009033},\"ticketingData\":\"T-\",\"ticketType\":\"ALREADY_TICKETED\"}]},\"remarks\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"e9e828bc-134a-4928-994e-dc141cb6f9f4\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510824}},\"supplementaryInfos\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"813124ef-a470-4cf1-a687-713649c0f24d\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510019}},\"formsOfPayment\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"b02c5245-8054-4dd7-8d34-10be22657464\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510926}},\"emailAddresses\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5eab4c7e-c3f8-4ffd-a90e-801e363d7844\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510900}},\"loyalties\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5cd5a752-8824-458a-8d29-e36e6d31655d\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8509930}},\"accountCodes\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"a7c762dd-6b6d-4dc1-8c6d-e5f46cf1386c\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8511039}},\"subscriptionCards\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"cbbbe6b4-a293-4f83-8466-f1c988482bf6\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510636}},\"ticketingData\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"8fded55e-44a5-45a9-aa83-c9ba7bf340d2\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8510510}},\"profileIndices\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"d98ec397-a544-4998-82d7-640c352f36fd\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8509702}},\"descriptiveBillingInfos\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5851dfc4-2965-47d8-b37e-162f33bc021b\",\"createTime\":1625140118446,\"version\":1625140118446,\"orsId\":8511403}}},\"@type\":\"PNRContent@pnr\"},\"PNR_HISTORY\":{\"header\":{\"id\":\"2886d6a8-4dab-4851-8886-8c78d0284d4e\",\"createTime\":1625143312588,\"version\":1625143312588,\"@type\":\"VersionedHeader\"},\"type\":\"PNR_HISTORY\",\"@type\":\"PNRHistoryContent@pnr\",\"historyTransactions\":[{\"transactionHeader\":{\"header\":{\"@type\":\"VersionedHeader\",\"id\":\"8de344d2-40da-448a-abf7-01287b80759f\",\"createTime\":1625140154427,\"version\":1625140154433},\"sequenceNumber\":1},\"entries\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"0bde5319-540e-4c77-b99c-f3cd2e784b67\",\"createTime\":1625140118457,\"version\":1625140154427,\"orsId\":8510804},\"elementId\":{\"id\":\"f92cb4e4-77e3-41ea-b536-b022674dff55\"},\"parentId\":{\"id\":\"f687554b-9cc2-464e-bfbc-54a5f785d388\"},\"dataType\":\"PhoneDeltaActionData@pnr\",\"endState\":{\"@type\":\"PhoneDeltaActionData@pnr\",\"phone\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"f92cb4e4-77e3-41ea-b536-b022674dff55\",\"createTime\":1625140118457,\"version\":1625140154425,\"orsId\":10341216},\"number\":\"DFW59595959\"},\"actionDataPath\":\"phone\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"ca1e9283-c915-4393-9d61-af84073be90d\",\"createTime\":1625140124099,\"version\":1625140154427,\"orsId\":8509770},\"elementId\":{\"id\":\"5e1ee5a5-5b19-4831-b9d2-31d99115e2df\"},\"parentId\":{\"id\":\"af5b21a1-21b4-44be-b4bb-610ed1c9b643\"},\"dataType\":\"ReceivedFromDeltaActionData@pnr\",\"endState\":{\"@type\":\"ReceivedFromDeltaActionData@pnr\",\"receivedFrom\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5e1ee5a5-5b19-4831-b9d2-31d99115e2df\",\"createTime\":1625140124099,\"version\":1625140154425,\"orsId\":13507532},\"receivedFrom\":\"-DAHRMENDRA\",\"type\":\"FREE_TEXT\"},\"actionDataPath\":\"receivedFrom\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"0a1234e2-db86-48fc-ab34-188389d1ed61\",\"createTime\":1625140124100,\"version\":1625140124100,\"orsId\":13510418},\"dataType\":\"ReceivedFromDeltaActionData@pnr\",\"endState\":{\"@type\":\"ReceivedFromDeltaActionData@pnr\",\"receivedFrom\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"5e1ee5a5-5b19-4831-b9d2-31d99115e2df\",\"createTime\":1625140124099,\"version\":1625140124099,\"changeIndicator\":\"C\",\"orsId\":13507532},\"receivedFrom\":\"-DAHRMENDRA\",\"type\":\"FREE_TEXT\"},\"actionDataPath\":\"receivedFrom\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"b24a64ed-2d2e-4704-8e96-a96139cc8cc1\",\"createTime\":1625140131023,\"version\":1625140154427,\"orsId\":8511445},\"elementId\":{\"id\":\"e88c0b1e-63a6-482b-9672-2c26cf915778\"},\"parentId\":{\"id\":\"12a841f7-8487-4d15-bc14-ced2fa94cb4d\"},\"dataType\":\"NameGroupDeltaActionData@pnr\",\"endState\":{\"@type\":\"NameGroupDeltaActionData@pnr\",\"nameGroup\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"e88c0b1e-63a6-482b-9672-2c26cf915778\",\"createTime\":1625140131023,\"version\":1625140154425,\"orsId\":10911432},\"items\":[{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"0b93a972-25c9-4bc0-8048-30f53f8f7c20\",\"createTime\":1625140131023,\"version\":1625140131023,\"orsId\":10911265},\"firstName\":\"DHARMENDRA\",\"lastName\":\"KUMAR\",\"nameType\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"1988f6c8-4087-4f5f-bea9-2636c169235e\",\"createTime\":1625140131024,\"version\":1625140131024,\"orsId\":10912014},\"code\":\"ADT\"},\"nameId\":1,\"ordinal\":1,\"position\":1,\"primeNameIndicator\":true}]},\"actionDataPath\":\"nameGroup\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"f73f0ee5-c438-4761-8178-faf31e32f68b\",\"createTime\":1625140135115,\"version\":1625140154427,\"orsId\":8511339},\"elementId\":{\"id\":\"39665b1c-631c-434a-902e-efc891d72650\"},\"parentId\":{\"id\":\"f6246bfa-696f-4b3b-8da4-fd038275f922\"},\"dataType\":\"ProductDeltaActionData@pnr\",\"endState\":{\"@type\":\"ProductDeltaActionData@pnr\",\"product\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"39665b1c-631c-434a-902e-efc891d72650\",\"createTime\":1625140135115,\"version\":1625140154425,\"orsId\":10902707},\"cityCode\":\"BLR\",\"vendorCode\":\"AA\",\"actionCode\":\"GK\",\"previousActionCode\":\"GK\",\"numberInParty\":1,\"startDate\":\"2022-03-30\",\"segmentNumber\":1,\"productType\":\"OTHER\",\"otherProductDetails\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"cda206bc-e48e-4eee-af5b-1c03194a62d5\",\"createTime\":1625140135115,\"version\":1625140135115,\"orsId\":10902254}}},\"actionDataPath\":\"product\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"fff86d2a-24be-4dfe-b050-81567dd2c6f8\",\"createTime\":1625140142870,\"version\":1625140154427,\"orsId\":8511389},\"elementId\":{\"id\":\"9c7f54ab-adfd-42dc-8058-e907d093108f\"},\"parentId\":{\"id\":\"56b683fa-38dd-47c8-be55-38dd35e1feab\"},\"dataType\":\"TicketingDeltaActionData@pnr\",\"endState\":{\"@type\":\"TicketingDeltaActionData@pnr\",\"ticket\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"9c7f54ab-adfd-42dc-8058-e907d093108f\",\"createTime\":1625140142871,\"version\":1625140154425,\"orsId\":10009033},\"ticketingData\":\"T-\",\"ticketType\":\"ALREADY_TICKETED\"},\"actionDataPath\":\"ticket\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"db32e6d0-5732-458e-9b5e-4d313ceed1ea\",\"createTime\":1625140154411,\"version\":1625140154427,\"orsId\":8510897},\"elementId\":{\"id\":\"7d12e2d7-c61e-4958-9528-9b71fc77200e\"},\"parentId\":{\"id\":\"af5b21a1-21b4-44be-b4bb-610ed1c9b643\"},\"dataType\":\"PNRHeaderDeltaActionData@pnr\",\"endState\":{\"@type\":\"PNRHeaderDeltaActionData@pnr\",\"pnrHeader\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"7d12e2d7-c61e-4958-9528-9b71fc77200e\",\"createTime\":1625140154411,\"version\":1625140154425,\"orsId\":8477443},\"locator\":\"MJADWN\",\"createDate\":\"2021-07-01T11:49:14.411431Z\",\"locatorCreateTime\":\"MJADWN2021-07-01\",\"etCount\":1,\"pnrPurgeDate\":\"2022-03-30\",\"lastEndTransactionDateAndTime\":\"2021-07-01T11:49:14.411467Z\",\"numberInParty\":1},\"actionDataPath\":\"pnrHeader\"}},{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"ca6096e2-debd-4c65-a39c-c53ebac0e35d\",\"createTime\":1625140154411,\"version\":1625140154411,\"orsId\":8477770},\"dataType\":\"HistorySignatureDeltaActionData@pnr\",\"endState\":{\"@type\":\"HistorySignatureDeltaActionData@pnr\",\"historySignature\":{\"header\":{\"@type\":\"PNRElementHeader@pnr\",\"id\":\"d5ebbd05-dd91-42a1-a488-7770379b3a8d\",\"createTime\":1625140154411,\"version\":1625140154411,\"orsId\":8478463},\"receivedFrom\":\"-DAHRMENDRA\",\"bookingCityCode\":\"B4T0\",\"homeCityCode\":\"HDQ\",\"dutyCode\":\"8\",\"agentSine\":\"-DK\"},\"actionDataPath\":\"historySignature\"}}]}]}}}}]}]}";


    private EtConstants() {
    }
}
