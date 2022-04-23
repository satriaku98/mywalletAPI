Java Stream Count

long countData = transactionService.listTransactionByWalletId(wallet_id).stream().count();
String message = String.format(ResponseMassage.DATA_COUNT, wallet_id,countData);

Postman Collection Link
https://web.postman.co/collections/a8fcf033b6adbfb3ae2c
