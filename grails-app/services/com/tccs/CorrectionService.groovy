package com.tccs

import grails.transaction.Transactional
import com.tccs.type.StatusType
import com.tccs.type.ReasonType
import com.tccs.type.EntryType

@Transactional
class CorrectionService {

	Correction saveCorrection(Date dateTimeCorrection, ReasonType reason, EntryType entryRequired, String comment, User user) {

		def correction = new Correction(
										dateTimeCorrection: dateTimeCorrection,
										reason: reason,
										entryRequired: entryRequired,
										comment: comment,
										status: StatusType.STATUS_PENDING,
										user: user)

		correction.save(failOnError: true, flush: true)

		return correction
	}

	Correction updateCorrection(Long id, StatusType status) {

		def correction = Correction.get(id)
		correction.status = status

		correction.save(failOnError: true, flush: true)
	}
}
