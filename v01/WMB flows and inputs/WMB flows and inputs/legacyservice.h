	/******************************************************************/
/* File Name:     legacyservice.h                                 */
/*                                                                */
/* Header for use with header for use with legacyservice.cpp      */
/*                                                                */
/******************************************************************/


/*   Message Types   */
#define BUY_MESSAGE              "IA81BUY "
#define CONFIRMATION_MESSAGE     "IA81CONF"
#define ORDER_MESSAGE            "IA81ORD "
#define REQUEST_PRICE            "IA81ASKP"
#define PROVIDE_PRICE            "IA81PRI " 

/*   Message Structures   */
/* ***************************************************************** */
/* Structure of buy message                                          */
/* ***************************************************************** */
typedef struct tagIA81BUY {
   char MessageId[8];
   char OrderNumber[8];
   char ItemReference[12];
   char ItemQuantity[8];
   char CustomerNumber[12];
   char DeliveryRef[8];
} IA81BUY;

typedef struct tagIA81CONF {
   char MessageId[8];
   char OrderNumber[8];
   char ItemReference[12];
   char ItemQuantity[8];
   char CustomerNumber[12];
   char DeliveryRef[8];
   char Confirm[1];
   char filler1[3];
} IA81CONF;

/* ***************************************************************** */
/* Structure of price message                                        */
/* ***************************************************************** */
typedef struct tagIA81ASKP {
   char MessageId[8];
   char ItemReference[12];
   char ItemQuantity[8];
   char CustomerNumber[12];
} IA81ASKP;

typedef struct tagIA81PRI {
   char MessageId[8];
   char ItemReference[12];
   char ItemQuantity[8];
   char CustomerNumber[12];
   char ItemUnitPrice[8];
} IA81PRI;
