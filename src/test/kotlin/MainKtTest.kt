import org.junit.Test

import org.junit.Assert.*
 class MainKtTest {

  @Test
  fun sumFeeMaestroYes1() {
   val cardType = "Maestro"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 30_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(50, result)
  }

  @Test
  fun sumFeeMaestroNo() {
   val cardType = "Maestro"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(0, result)
  }

  @Test
  fun sumFeeMaestroYes2() {
   val cardType = "Maestro"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 200.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(21, result)
  }

  @Test
  fun sumFeeMastercardYes1() {
   val cardType = "Mastercard"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 30_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(50, result)
  }

  @Test
  fun sumFeeMastercardNo() {
   val cardType = "Mastercard"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(0, result)
  }

  @Test
  fun sumFeeMastercardYes2() {
   val cardType = "Mastercard"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 200.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(21, result)
  }



  @Test
  fun wrongCardType() {
   val cardType = "Bobiboba"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 30_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-2, result)
  }

  @Test
  fun dayLimitOffVisa() {
   val cardType = "Visa"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun dayLimitOffMir() {
   val cardType = "Мир"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun dayLimitOffMastercard() {
   val cardType = "Mastercard"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun dayLimitOffMaestro() {
   val cardType = "Maestro"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 50_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 300_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun dayLimitOffVK() {
   val cardType = "VK Pay"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 20_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 15_001.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun monthLimitOffVK() {
   val cardType = "VK Pay"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 30_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 14_999.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun sumFeeVK() {
   val cardType = "VK Pay"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 20_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 14_999.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(0, result)
  }

  @Test
  fun monthLimitOff() {
   val cardType = "Bobiboba"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 590_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 30_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(-1, result)
  }

  @Test
  fun sumFeeVisaMin() {
   val cardType = "Visa"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 4_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(35, result)
  }

  @Test
  fun sumFeeVisaRate() {
   val cardType = "Visa"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 10_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(75, result)
  }

  @Test
  fun sumFeeMirMin() {
   val cardType = "Мир"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 4_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(35, result)
  }

  @Test
  fun sumFeeMirRate() {
   val cardType = "Мир"    // Варианты: Visa, Мир, Mastercard, Maestro, VK Pay
   val totalHasTransfered = 70_000.0   // Сумма переводов за этот месяц
   val sumTransfer = 10_000.0

   val result = sumFee(sumTransfer, totalHasTransfered, cardType).toInt()

   assertEquals(75, result)
  }

 }