const express = require('express');
const userRoutes = require('./user.route');
const charityRoutes = require('./charity.route');

const router = express.Router();

// TODO: Mount routes

router.use("/user", userRoutes);
router.use("/charity", charityRoutes);

module.exports = router;
