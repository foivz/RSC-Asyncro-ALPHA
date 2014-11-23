<?php
/**
 * Created by PhpStorm.
 * User: YogurtBox
 * Date: 23.11.2014.
 * Time: 5:45
 */

class Notification {

    public static function Send($gcmId, $title, $message){

        if($gcmId) {

            PushNotification::app('appNameAndroid')
                ->to($gcmId)
                ->send(json_encode(['title' => $title, 'message' => $message]));

        }

    }

} 