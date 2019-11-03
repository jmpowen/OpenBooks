const express = require('express');
const axios = require('axios');

const router = express.Router();

router.get('/1', function(req, res, next) {
  console.log("FUCK");
  axios.get(`http://10.27.165.202:8080/api/charity/1`)
    .then(res2 => {
      const charity = res2.data;
      res.data(charity);
    })
});

module.exports = router;
