<?php
require "conn.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new conn();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }


    function signUp($user, $NamaFull, $nickname, $email, $password, $phone, $yoc)
    {
        $NamaFull = $this->prepareData($NamaFull);
        $nickname = $this->prepareData($nickname);
        $email = $this->prepareData($email);
        $password = $this->prepareData($password);
        $phone = $this->prepareData($phone);
        $yoc = $this->prepareData($yoc);
        $email = filter_var($email, FILTER_VALIDATE_EMAIL);
        $password = password_hash($password, PASSWORD_BCRYPT);
        
        $dbc = mysqli_connect("localhost","id17942833_user",'BimbelJayaJaya2!','id17942833_bimbel') or die ('Error connecting to MYSQL server');
        $check = mysqli_query($dbc, "select * from user where email = '$email'");
        $checkrows = mysqli_num_rows($check);
        
        if($checkrows > 0) {
            echo "User already registered ";
        }else {
            $this->sql = 
            "INSERT INTO " . $user . " (NamaFull, nickname, email, password, phone, yoc) VALUES ('" . $NamaFull . "','" . $nickname . "','" . $email . "','" . $password . "','" . $phone . "','" . $yoc . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    
}
}
?>